package com.cg.ova.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ova.dao.ICartDTORepository;
import com.cg.ova.entity.CartDTO;
import com.cg.ova.model.CartDTOModel;

@Service
public class EMParserCartDTO {
	@Autowired
	private ICartDTORepository cartDAO;
	
	@Autowired
	private EMParserCustomer customerParser;
	
	
	public EMParserCartDTO() {
		this.customerParser=new EMParserCustomer();
		
		}
	
  
	public EMParserCartDTO(ICartDTORepository cartDAO) {
		super();
		this.cartDAO = cartDAO;
		this.customerParser=new EMParserCustomer();
		
	}
	 //convert cart model to cart entity
	public CartDTOModel parse(CartDTO source) {
		return source==null ? null:
			new CartDTOModel (source.getCartId(),
					customerParser.parse(source.getCustomer())
					
					);
	}
		
	//convert cart entity to cart model
		public CartDTO parse(CartDTOModel source) {
			return source==null ? null:
				new CartDTO (source.getCartId(),
						customerParser.parse(source.getCustomer())
						);

}
	}
