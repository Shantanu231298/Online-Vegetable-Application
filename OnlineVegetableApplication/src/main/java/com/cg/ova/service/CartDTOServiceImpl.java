package com.cg.ova.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ova.dao.ICartDTORepository;
import com.cg.ova.entity.CartDTO;
import com.cg.ova.exception.CartIdNotFoundException;
import com.cg.ova.model.CartDTOModel;
import com.cg.ova.model.VegetableDTOModel;
import com.cg.ova.util.EMParserCartDTO;

@Service
public class CartDTOServiceImpl implements ICartDTOService {
	
	@Autowired
	private ICartDTORepository cartDAO;
	@Autowired
	private EMParserCartDTO parser;
	
	public CartDTOServiceImpl() {
		this.parser = new EMParserCartDTO();
		
	}
	
	  public CartDTOServiceImpl(ICartDTORepository cartDAO) {
			super();
			this.cartDAO = cartDAO;
			this.parser = new EMParserCartDTO();
		}

	 /* Implementation of addCart to add item to cart */
	@Transactional
	@Override
	public CartDTOModel addToCart(CartDTOModel cart, VegetableDTOModel veg) throws CartIdNotFoundException {
		
		if (veg != null) {
			if (cartDAO.existsById(veg.getVegId())) {
				throw new CartIdNotFoundException ("vegetable with this id already exists");
			}
			
			List<VegetableDTOModel> vegetable1= new ArrayList<>();
			vegetable1.add(veg);
			cart.setVegetables(vegetable1);
			
			
			cart = parser.parse(cartDAO.save(parser.parse(cart)));
		}

		return cart;
	}
	
	/* Implementation of increaseVegQuantity  to inc item quantity */
	@Transactional
	@Override
	public CartDTOModel increaseVegQuantity(CartDTOModel cart, VegetableDTOModel veg, int quantity) throws CartIdNotFoundException {
		if (veg != null) {
			if (!cartDAO.existsById(veg.getVegId())) {
				throw new CartIdNotFoundException(" vegetable with this id does not exists");
			}
			veg.setQuantity(veg.getQuantity() + quantity);
			veg.setCartDTO(cart);
			cart = parser.parse(cartDAO.save(parser.parse(cart)));
		}

		return cart;
	}
	
	/* Implementation of decreaseVegQuantity  to dec item quantity */
	@Transactional
	@Override
	public CartDTOModel decreaseVegQuantity(CartDTOModel cart, VegetableDTOModel veg, int quantity) throws CartIdNotFoundException {
		if (veg != null) {
			if (!cartDAO.existsById(veg.getVegId())) {
				throw new CartIdNotFoundException(" vegetable with this id does not exists");
			}
			veg.setQuantity(veg.getQuantity() - quantity);
			veg.setCartDTO(cart);
			cart = parser.parse(cartDAO.save(parser.parse(cart)));
		}

		return cart;
	}

	/* Implementation of removeVeg  to remove veg from cart */
	@Transactional
	@Override
	public boolean removeVeg(Long cartId) throws CartIdNotFoundException {
		boolean isDeleted= false;
		if (cartId != null) {
			if (!cartDAO.existsById(cartId)) {
				throw new CartIdNotFoundException("vegetable with this id not exists");
			}
			cartDAO.deleteById(cartId);
			isDeleted=true;
		}
		return isDeleted;
	}
	
	//Implementation of removeAllVeg  to remove all vegetables
	@Transactional
	@Override
	public CartDTOModel removeAllVegetable(CartDTOModel cart) throws CartIdNotFoundException {
		cartDAO.deleteAll();
		return cart;
	}

	//Implementation of viewCart to view all vegetables in a cart by cart id
	@Override
	public CartDTOModel viewCart(Long cartId) throws CartIdNotFoundException{
    	CartDTO oldCart = cartDAO.findById(cartId).orElse(null);
    	System.out.println(oldCart);
		if (oldCart == null) {
			throw new CartIdNotFoundException("no cart with id #" + cartId + " present");
		}
		return parser.parse(cartDAO.findById(cartId).orElse(null));
	}
	
	
	//Implementation of viewAllItem to view all vegetables in a cart 
   @Override
	public List<CartDTOModel> viewAllItems() throws CartIdNotFoundException {
        List<CartDTO> list= cartDAO.findAll();
		
		List<CartDTOModel> retList= new ArrayList<>();
		
		for(CartDTO cart: list)
			retList.add(parser.parse(cart));
		
		return retList;

	}
}