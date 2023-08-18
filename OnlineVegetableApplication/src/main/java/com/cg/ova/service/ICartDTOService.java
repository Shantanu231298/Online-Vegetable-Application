package com.cg.ova.service;
import java.util.List;
import com.cg.ova.exception.CartIdNotFoundException;
import com.cg.ova.model.CartDTOModel;
import com.cg.ova.model.VegetableDTOModel;

public interface ICartDTOService {
	/* definition of addToCart method for adding item to cart */
	public CartDTOModel addToCart(CartDTOModel cart,VegetableDTOModel veg) throws CartIdNotFoundException;
	
	/* definition of incveg method to inc item in cart */
	public CartDTOModel increaseVegQuantity(CartDTOModel cart,VegetableDTOModel veg, int quantity) throws CartIdNotFoundException;
	
	/* definition of decveg method to dec item in cart */
	public CartDTOModel decreaseVegQuantity(CartDTOModel cart,VegetableDTOModel veg, int quantity) throws CartIdNotFoundException;
	
	/* definition of removeveg method to remove item in cart */
	public boolean removeVeg(Long cartId) throws CartIdNotFoundException;
	
	/* definition of removeAllveg method to remove all item in cart */
	public CartDTOModel removeAllVegetable(CartDTOModel cart) throws CartIdNotFoundException;
	
	/* definition of viewAllveg method to view all item in cart */
    public List<CartDTOModel> viewAllItems() throws CartIdNotFoundException;
    
    /* definition of viewCart method to item  in cart by cart id */
    public CartDTOModel viewCart(Long cartId) throws CartIdNotFoundException;
}
