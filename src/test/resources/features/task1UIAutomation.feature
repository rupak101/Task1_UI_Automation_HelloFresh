#Author: rupak101@gmail.com

Feature: register new customer and place a order

@registerNewUser
Scenario Outline: Register a new customer with all customer data
 Given open homepage url
 When click Sign in button
 And fill Email address to create an account
 And click Create an account 
 And Fill all fields with correct data "<firstName>","<lastName>","<address>","<city>","<postalCode>","<mobile>","<otherInfo>"
 And Click Register button
 Then verify the my account page is opened
 And Proper username "<firstName>","<lastName>" is shown in the header
 And Log out action is available
 
 Examples: 
 | firstName | lastName | address | city | postalCode| mobile | otherInfo |
 |testFirstName | testLastname| testAddress | berlin | 11111 | 222222222| testing |

@login
Scenario Outline: login with existing customer
 Given open homepage url
 When click Sign in button
 And  enter the Email address and password for already registered customer
 And  click sign in button for registered customer
 Then verify the my account page is opened
 And Proper username "<firstName>","<lastName>" is shown in the header
 And Log out action is available
 
 Examples: 
 | firstName | lastName |
 |testFirstName | testLastname|

@order
Scenario Outline: Order details for existing customer
 Given open homepage url
 When click Sign in button
 And  enter the Email address and password for already registered customer
 And  click sign in button for registered customer
 And choose the store type in the header
 And click the product with name "<ProductName>"
 And click Add to card button
 And click Proceed to checkout on cart page
 And click Proceed to checkout button on summary step
 And click Proceed to checkout button on address step
 And click by Terms of service to agree
 And click Proceed to checkout button on shipping step
 And click by payment method "<paymentMethod>"
 And click on I confirm my order button
 Then order confirmation page is opened
 And the order is complete.
 And current page is the last step of ordering 
 
 Examples: 
 | ProductName | paymentMethod |
 | Faded Short Sleeve T-shirts | Pay by bank wire|