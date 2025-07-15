package br.com.rocketskills.petlov;


class NewUser {

	String username;
	String usermail;
	String userPassword;
	String firstName;
	String lastName;
	String company;
	String address1;
	String address2;
	String city;
	String state;
	String zipCode;
	String country;
	String mobileNumber;

	public NewUser(String username, String usermail, String userPassword, String firstName, String lastName,
			String company, String address1, String adress2, String city, String state, String zipCode, String country,
			String mobileNumber) {
		this.username = username;
		this.usermail = usermail;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.address1 = address1;
		this.address2 = adress2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.mobileNumber = mobileNumber;
	}
}