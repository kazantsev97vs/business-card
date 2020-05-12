import React from "react";
import CustomForm from "../../../components/custom-form";
import inputs from "../log-in/inputs";
import {Link} from "react-router-dom";

const LogInRoute = () => {

    return (
        <div className="log-in-route container">

            <CustomForm
                name="Авторизация"
                inputs={inputs}
                onClick={console.log}
                buttonText="Войти"
            />

            <div className="row justify-content-center">
                <Link to="sign-up">или зарегистрироваться..?</Link>
            </div>

        </div>
    );
};

export default LogInRoute;