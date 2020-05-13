/**
 * Пользователь
 */
export default class User {

    id = null;

    firstName = "";

    lastName = "";

    login = "";

    password = "";

    email = "";

    gender = "";

    currentCity = "";

    businessCardList = [];


    constructor(firstName, lastName, login, password, email, gender, currentCity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.currentCity = currentCity;
    }
}