import React from "react";
import CustomForm from "../../../components/custom-form";
import loginPassword from "./login-password";

const SignUpSecondStep = ({match}) => {

    const saveFirstNameLastNameEmail = (form) => {
        console.log(form)

        // user.firstName = form.firstName;
        // user.lastName = form.lastName;
        // user.email = form.email;

    };

    console.log(match.path.split("/")[1] + "/add-info")
    return (
        <div>

            <CustomForm
                name="Придумайте логин и пароль"
                inputs={loginPassword}
                onClick={saveFirstNameLastNameEmail}
                href={"additional-information"}
            />

        </div>
    );
};

export default SignUpSecondStep;