package com.game.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.game.model.game.GameReferral;
import com.game.model.user.ClaimDetail;
import com.game.model.user.Roles;
import com.game.model.user.UserOffer;
import com.game.model.wallet.Wallet;



public class UserDto {
	public UserDto() {
		super();
	}
	
	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserFname() {
		return userFname;
	}
	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public Roles getRoles() {
		return roles;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public Date getUserCreatedDate() {
		return userCreatedDate;
	}
	public void setUserCreatedDate(Date userCreatedDate) {
		this.userCreatedDate = userCreatedDate;
	}
	private String userPassword;
	@Transient
	private Wallet wallet;
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	private String userFname;
	private String userLname;	
	public String getUserLname() {
		return userLname;
	}
	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}
	@Transient
	private GameReferral referal;
	public GameReferral getReferal() {
		return referal;
	}
	public void setReferal(GameReferral referal) {
		this.referal = referal;
	}
	private String displayName;
	
	private Roles roles ;
	@Transient 
	private UserOffer offer ;
	private String userMobile;
	@Temporal(TemporalType.TIMESTAMP)
	private Date  userCreatedDate;
	@Transient
	private ClaimDetail claimDetail;
	public UserOffer getOffer() {
		return offer;
	}
	public void setOffer(UserOffer offer) {
		this.offer = offer;
	}
	public ClaimDetail getClaimDetail() {
		return claimDetail;
	}
	public void setClaimDetail(ClaimDetail claimDetail) {
		this.claimDetail = claimDetail;
	}
	

}
