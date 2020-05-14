import Service from "../service";

export default class UserController extends Service {

    USER_URL = "/user";

    checkEmailUniqueness = async (email) => {
        const response = await this.GET(this.USER_URL + `/email=${email}`);
        return response.content;
    };

    checkLoginUniqueness = async (login) => {
        const response = await this.GET(this.USER_URL + `/login=${login}`);
        return response.content;
    };

    signUp = async (user) => {
        const response = await this.PUT(this.USER_URL + "/sign-up", user);
        return this.promise(response);
    };

    logIn = async (logInUser) => {
        const response = await this.POST(this.USER_URL + "/log-in", logInUser);
        return this.promise(response);
    };

    logOut = async (logInUser) => {
        const response = await this.POST(this.USER_URL + "/log-out", logInUser);
        return this.promise(response);
    };

    updateUser = async (userField) => {
        const response = await this.PATCH(this.USER_URL, userField);
        return this.promise(response);
    };

    deleteUser = async (userId) => {
        const response = await this.DELETE(this.USER_URL + userId);
        return this.promise(response);
    };

}