package com.game.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.GameService.LoginService;
import com.game.GameService.MailService;
import com.game.GameService.OfferService;
import com.game.GameService.PaymentService;
import com.game.GameService.ReferralService;
import com.game.GameService.WalletService;
import com.game.model.ApiResponse;
import com.game.model.user.ClaimDetail;
import com.game.model.user.User;
import com.game.model.wallet.Wallet;
import com.game.model.wallet.WalletAudit;
import com.game.repository.UserOfferRepository;
import com.game.repository.UserRepository;
import com.game.repository.WalletRepository;
import com.game.service.UserService;
import com.game.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	

	Double INITIAL_WALLET_AMOUNT = 10.00;
	@Autowired
	private WalletService walletService;

	@Autowired
	private OfferService offerService;
	
	@Autowired
	private PaymentService paymentService;
	
	
	
	@Autowired
	private LoginService loginService;
	
	




	@PostMapping("/login")
	public Object getUserByRole(@Valid @RequestBody User user) {
		return loginService.login(user);
	}

	

	@PostMapping("/addPlayer")
	public Object createplayer(@Valid @RequestBody User user) {
		return loginService.addPlayer(user);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/updatewalletbyuser")
	public ResponseEntity<Object> updatewalletbyUser(@Valid @RequestBody Wallet wallet) {
		System.out.println(wallet.getUserId());
		return ResponseEntity.status(HttpStatus.OK).body(walletService.updateWalletByUserId(wallet.getUserId(), wallet.getWalletAmount(),"CREDIT"));
		
	}
	
	@PostMapping("/updatewallet")
	public ResponseEntity<Object> updatewallet(@Valid @RequestBody WalletAudit wallet) {
		return ResponseEntity.status(HttpStatus.OK).body(walletService.updateWalletbyId(wallet));
		
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/getwalletbyid")
	public ResponseEntity<Object> getWalletById(@Valid @RequestBody Wallet wallet) {
		return ResponseEntity.status(HttpStatus.OK).body(walletService.getWalletById(wallet.getWalletId()));
		
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/claimamount")
	public ResponseEntity<Object> claimAmount(@Valid @RequestBody ClaimDetail claimDetail) {
		return ResponseEntity.status(HttpStatus.OK).body(paymentService.handleClaim(claimDetail));
		
	}
	



	

	


}