package com.game.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.game.model.ApiResponse;
import com.game.model.user.User;
import com.game.repository.ClaimDetailRepository;
import com.game.repository.UserOfferRepository;
import com.game.repository.UserRepository;
import com.game.repository.WalletRepository;
import com.game.util.GameUtil;
import com.game.model.Constants;

@Component
public class LoginService {
	@Autowired
	private UserRepository userRepository;

	
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private WalletService walletService;
	
	@Autowired
	private OfferService offerService;
	
	@Autowired
	private MailService mailService;

	@Autowired
	private ReferralService referralService;

	@Autowired
	private UserOfferRepository userOfferRepository;


	
	@Autowired
	ClaimDetailRepository claimrepo;
	
	public Object login(User user) {
		User loggedInUser = userRepository.findByUserIdAndUserPassword(user.getUserId(), user.getUserPassword());
		if (loggedInUser != null && loggedInUser.getUserId() != null) {
			loggedInUser.setWallet(walletRepository.findByUserId(loggedInUser.getUserId()));
			loggedInUser.setOffer(userOfferRepository.findByGameUser(loggedInUser.getUserId()));
		}
		return loggedInUser;
	}
	
	public Object addPlayer(User user) {
		User newPlayer = new User();
		if (null != userRepository.findByUserId(user.getUserId())) {
			return "User Already Exists";
			
	 } else {
		
		try{
			newPlayer = userRepository.save(user);
			walletService.createWallet(newPlayer);									
			newPlayer.setOffer(offerService.associateOffer(newPlayer));
			referralService.addReferral(user);
			mailService.sendEmailDelay(user.getUserId());
			return newPlayer;
		}
		catch(Exception e){		
			e.printStackTrace();
		}
	}
		return newPlayer;
		
	}
		

}
