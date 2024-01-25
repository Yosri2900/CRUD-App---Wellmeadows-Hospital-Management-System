package SEG3102.HMSPMS.adapters.services.implementation

import SEG3102.HMSPMS.application.services.DomainEventListener
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class DomainEventListenerAdapter: DomainEventListener {
//    @Async
//    @EventListener
//    override fun handleNewItemAddedEvent(event: NewItemAdded) {
//        println(event.occuredOn.toString() + " New Item Added: " + event.itemId)
//    }
//
//    @Async
//    @EventListener
//    override fun handleCreditCardCreatedEvent(event: CreditCardCreated) {
//        println(event.occuredOn.toString() + " New Credit Card Added: " + event.creditCardNumber)
//    }
//
//    @Async
//    @EventListener
//    override fun handleUserAccountCreatedEvent(event: UserAccountCreated) {
//        println(event.occuredOn.toString() + " New User Account Created: " + event.userId)
//    }
//
//    @Async
//    @EventListener
//    override fun handleUserAccountDeactivatedEvent(event: UserAccountDeactivated) {
//        println(event.occuredOn.toString() + " User Account Deactivated: " + event.userId)
//    }
//
//    @Async
//    @EventListener
//    override fun handleUserAccountUpdatedEvent(event: UserAccountUpdated) {
//        println(event.occuredOn.toString() + " User Account Updated: " + event.userId)
//    }
//
//    @Async
//    @EventListener
//    override fun handleUserCreditCardSetEvent(event: UserCreditCardSet) {
//        println(event.occuredOn.toString() + " User CreditCard Set: " + event.userId + " to " + event.creditCardNumber)
//    }
//
//    @Async
//    @EventListener
//    override fun handleAuctionClosedEvent(event: AuctionClosed) {
//        println(event.occuredOn.toString() + " Auction Closed: " + event.auctionId + " winner " + event.winnerId)
//    }
//
//    @Async
//    @EventListener
//    override fun handleNewAuctionAddedEvent(event: NewAuctionAdded) {
//        println(event.occuredOn.toString() + " New Auction Added: " + event.auctionId)
//    }
//
//    @Async
//    @EventListener
//    override fun handleNewAuctionBidRegisteredEvent(event: NewAuctionBidRegistered) {
//        println(event.occuredOn.toString() + " New Bid Registered: " + event.bidId to " Account " + event.userId)
//    }
//
//    @Async
//    @EventListener
//    override fun handleNewBidCreatedEvent(event: NewBidCreated) {
//        println(event.occuredOn.toString() + " New Bid Created: " + event.bidId)
//    }
}