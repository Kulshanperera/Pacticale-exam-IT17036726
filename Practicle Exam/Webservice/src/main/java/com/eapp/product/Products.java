package com.eapp.product;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

	@Entity
	@Table(name="productlist")
	@EntityListeners(AuditingEntityListener.class)
	public class Products implements Serializable{
		@Id 
		@GeneratedValue(strategy=GenerationType.AUTO)
		private static final long serialVersionUID = -1232395859408322328L;

		private int product_id;
		private String name;
		private int price;
		private String description;
		
		
		public int getProduct_id() {
			return product_id;
		}
		public void setPrice(int price) {
			this.price = price;
		}

		public int getPrice() {
			return price;
		}
		public void setProduct_id(int product_id) {
			this.product_id = product_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
	
}
