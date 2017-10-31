package com.niit.frontend.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mobilebackend.dao.ICartDao;
import com.niit.mobilebackend.dao.ICartItemDao;
import com.niit.mobilebackend.dao.IProductDao;
import com.niit.mobilebackend.dao.IUserDao;
import com.niit.mobilebackend.model.Cart;
import com.niit.mobilebackend.model.CartItem;
import com.niit.mobilebackend.model.Product;
import com.niit.mobilebackend.model.User;



@Controller
public class CartController {
	

		@Autowired
		ICartDao cartDAO;

		@Autowired
		Cart cart;

		@Autowired
		IProductDao productDAO;

		@Autowired
		Product product;

		@Autowired
		IUserDao userDAO;

		@Autowired
		User user;
		
		
		
		@Autowired
		ICartItemDao cartItemDAO;
		
		@Autowired
		HttpSession httpSession;

		
		// cart
		/*@RequestMapping(value = "/viewcart{id}")
		public ModelAndView viewmycart(@PathVariable("id") String id) {
			int s = Integer.parseInt(id);

			ModelAndView mv = new ModelAndView("mycart");
			mv.addObject("cartList", cartDAO.listcartproducts(s));
			// mv.addObject("cartprice", cartDAO.totalprice(id));
			return mv;
		}
*/
		/*@RequestMapping(value = "/buy{id}&{pid}", method = RequestMethod.POST)
		public ModelAndView buyproductPage(@PathVariable("id") String id, @PathVariable("pid") String pid,
				@RequestParam("quantity") int quantity, HttpSession session) throws Exception {
			
			int i=Integer.parseInt(id);
			int ppid=Integer.parseInt(pid);
			user=userDAO.getbyid(i);
		ModelAndView mv = new ModelAndView("addtocart");
		//int k = Integer.parseInt(quantity);
		int y = 0;
		Cart kcart = new Cart();
		for (Cart temp : cartDAO.listcartproducts(i)) {
			if (temp.getProdid()==ppid) {
				y = 1;
				kcart = temp;
			}
		}
		if (y == 1) {
			kcart.setQuantity(kcart.getQuantity() + quantity);
			kcart.setPrice(kcart.getQuantity() * kcart.getCartproduct().getProd_price());
			cartDAO.update(kcart);
		} else {
			cart.setQuantity(quantity);
			cart.setUser_id(i);
			cart.setProd_id(ppid);
			cart.setCartuser(userDAO.getbyid(i));
			product = productDAO.get(ppid);
			cart.setCartproduct(product);
			cart.setPrice(cart.getQuantity() * product.getProd_price());
			cartDAO.save(cart);
		}
		mv.addObject("cartList", cartDAO.listcartproducts(i));
		mv.addObject("cartprice", cartDAO.totalprice(cart.getUser_id()));
		return mv;
		}
		
		
		@RequestMapping("/viewcart")
		public ModelAndView viewCart(@RequestParam("userid")String uid,Model model) {
			int id=Integer.parseInt(uid);
			System.out.println("viewing cart");
			model.addAttribute("cartprice", cartDAO.totalprice(cart.getUserid()));
			model.addAttribute("cartList", cartDAO.listcartproducts(id));
			return new ModelAndView("addtocart");
		}
*/		/*@RequestMapping(value = "/deletecart{id}")
		public ModelAndView deleteCategory(@PathVariable("id") String id, HttpSession session) throws Exception {
			int i=Integer.parseInt(id);
			cart = cartDAO.getbyid(i);
			cartDAO.delete(cart);
			ModelAndView mv = new ModelAndView("addtocart");
			mv.addObject("cartList", cartDAO.listcartproducts(cart.getUser()));
			session.setAttribute("cartvalue", cartDAO.totalproducts(cart.getUser_id()));
			mv.addObject("cartprice", cartDAO.totalprice(cart.getUser_id()));

			mv.addObject("cartmessage1", " has been deleted from your cart");
			return mv;
		}*/
/*@RequestMapping("/{id}/AddtoCart")
public String showCart(@PathVariable Integer id, ModelMap model) {

	model.addAttribute("cart", cartDAO.listcartproducts(id));

	return "AddtoCart";

}
*/

@RequestMapping(value = "{id}/deletecart/{pid}")
public String showDeleteCart(@PathVariable("id") String id, @PathVariable("pid") String pid, Model model) throws Exception {

	int i = Integer.parseInt(id);
	int j=Integer.parseInt(pid);
	System.out.println("user id: "+i+" cart id: "+j);
	cart =cartDAO.get(j,i);

	System.out.println("cart delete");

	//ModelAndView mv = new ModelAndView("viewproducts");

	cartDAO.delete(cart);
	//mv.addObject("viewproducts", 0);

	System.out.println("delete Id:" + id);
	return "redirect:/cart";
	//return mv;

}
@RequestMapping(value = "/editcart/{id}")
public ModelAndView updateCartPage(@PathVariable("id") String id, Model model) throws Exception {
	int i = Integer.parseInt(id);

	model.addAttribute("product", cartDAO.getbyid(i));
	
	/*model.addAttribute("productList", productDAO.list());
	model.addAttribute("supplierList", supplierDAO.list());
	model.addAttribute("categoryList", categoryDAO.list());*/
	cartDAO.update(cart);
	System.out.println("edit cart in controller");
	ModelAndView mv = new ModelAndView("addtocart");
	return mv;

}

@RequestMapping("/cart")
public String showCart()
{
	return "cart";
}
@RequestMapping("/{id}/cart")
public String addCart(@PathVariable Integer id, Principal principal,ModelMap model) {
	User user=userDAO.get(principal.getName());
     user.setCpassword(user.getPassword());
     Product product=productDAO.get(id);
     Cart cart=cartDAO.getCartWithUserId(user.getUserid());
     if(cart!=null)
     {
    	 System.out.println("cart is not null");
    	 cart.setUsers(user);
    		
    	CartItem cartItem=cartItemDAO.getExistingCartItemCount(id, cart.getCartid());
    	if(cartItem!=null)
    	{
    		cartItem.setCart(cart);
    		cartItem.setGrandtotal(cartItem.getGrandtotal()+product.getPrice());
    		cartItem.setQty(cartItem.getQty()+1);
    		cartItemDAO.updateCartItem(cartItem);
    	}
    	else{
    		cartItem=new CartItem();
    		cartItem.setCart(cart);
    		cartItem.setGrandtotal(product.getPrice());
    		cartItem.setProduct(product);
    		cartItem.setQty(1);
    		cartItemDAO.addCartItem(cartItem);
    	}
    	cart.setGrandtotal(cart.getGrandtotal()+product.getPrice());
    	cart.setQty(cart.getQty()+1);
    	List<CartItem> cartItems=cart.getCartitems();
    	cartItems.add(cartItem);
    	cart.setCartitems(cartItems);
    	cartDAO.update(cart);
    	
     }else
     {
    	 System.out.println("cart is adding");
    	 cart=new Cart();
    	 cart.setGrandtotal(product.getPrice());
    	 cart.setQty(1);
    	 cart.setUsers(user);
    	 CartItem cartItem=new CartItem();
    	 cartItem.setCart(cart);
    	 cartItem.setGrandtotal(product.getPrice());
    	 cartItem.setProduct(product);
    	 cartItem.setQty(1);
    	 
    	 cartDAO.save(cart);
    	 cartItemDAO.addCartItem(cartItem);
     }
     
     model.addAttribute("mycartList", cartDAO.listcartproducts(user.getUserid()));
			return "cart";
}
	     

	


	/*@RequestMapping("/{id}/ViewDetails")
			public String showDetails(@PathVariable Integer id, ModelMap model) {
				model.addAttribute("product", productDAO.get(id));
				return "ViewDetails";
			}*/
		
			/*@RequestMapping("/allproducts")
			public @ResponseBody List<Product> productsall() {
				System.out.println("inside products all");
				return productDAO.list();
			}*/


	


}
