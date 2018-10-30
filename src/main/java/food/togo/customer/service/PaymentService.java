package food.togo.customer.service;

import java.util.HashMap;
import java.util.Map;

import com.stripe.exception.*;
import com.stripe.model.Customer;
import food.togo.customer.mysqldao.entities.CustomerEntity;
import food.togo.customer.request.ChargeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.model.Charge;

@Service("payment")
public class PaymentService {

    //@Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey = "pk_test_JMlbR4PSbP5qPVON78QsDW8b";

    public PaymentService() {
        Stripe.apiKey = stripePublicKey;
    }

    public String createStripeCustomer(CustomerEntity user) {

        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("description",
                user.getFirstName() + " " + user.getLastName());
        customerParams.put("email", user.getEmail());

        String id = null;

        try {
            // Create customer
            Customer stripeCustomer = Customer.create(customerParams);
            id = stripeCustomer.getId();
            System.out.println(stripeCustomer);
        } catch (CardException e) {
            // Transaction failure
        } catch (RateLimitException e) {
            // Too many requests made to the API too quickly
        } catch (InvalidRequestException e) {
            // Invalid parameters were supplied to Stripe's API
        } catch (AuthenticationException e) {
            // Authentication with Stripe's API failed (wrong API key?)
        } catch (ApiConnectionException e) {
            // Network communication with Stripe failed
        } catch (StripeException e) {
            // Generic error
        } catch (Exception e) {
            // Something else happened unrelated to Stripe
        }

        return id;
    }

    public Charge chargeUsingTokenForFirstTimePayment(ChargeRequest chargeRequest)
            throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        try {
            // Submit charge to credit card
            Charge charge = Charge.create(chargeParams);
            System.out.println(charge);
            return charge;
        } catch (CardException e) {
            // Transaction was declined
            System.out.println("Status is: " + e.getCode());
            System.out.println("Message is: " + e.getMessage());
        } catch (RateLimitException e) {
            // Too many requests made to the API too quickly
        } catch (InvalidRequestException e) {
            // Invalid parameters were supplied to Stripe's API
        } catch (AuthenticationException e) {
            // Authentication with Stripe's API failed (wrong API key?)
        } catch (ApiConnectionException e) {
            // Network communication with Stripe failed
        } catch (StripeException e) {
            // Generic error
        } catch (Exception e) {
            // Something else happened unrelated to Stripe
        }
        return null;
    }


    public Charge chargeCreditCardForSavedStripeCustomer(ChargeRequest chargeRequest, String stripeCustomerId) {


        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("customer", stripeCustomerId);

        try {
            // Submit charge to credit card
            Charge charge = Charge.create(chargeParams);
            System.out.println(charge);
            return charge;
        } catch (CardException e) {
            // Transaction was declined
            System.out.println("Status is: " + e.getCode());
            System.out.println("Message is: " + e.getMessage());
        } catch (RateLimitException e) {
            // Too many requests made to the API too quickly
        } catch (InvalidRequestException e) {
            // Invalid parameters were supplied to Stripe's API
        } catch (AuthenticationException e) {
            // Authentication with Stripe's API failed (wrong API key?)
        } catch (ApiConnectionException e) {
            // Network communication with Stripe failed
        } catch (StripeException e) {
            // Generic error
        } catch (Exception e) {
            // Something else happened unrelated to Stripe
        }
        return null;
    }
}
