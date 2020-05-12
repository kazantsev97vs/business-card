import React from "react";
import CustomForm from "../../../components/custom-form";
import genderCurrentCity from "./gender-currentCity";

const SignUpThirdStep = () => {

    const saveFirstNameLastNameEmail = (form) => {
        console.log(form)

        // user.firstName = form.firstName;
        // user.lastName = form.lastName;
        // user.email = form.email;

    };

    return (
        <div>

            <CustomForm
                width={500}
                name="Заполните дополниельные данные"
                inputs={genderCurrentCity}
                onClick={saveFirstNameLastNameEmail}
                href={"/"}
            />

        </div>
    );
};

export default SignUpThirdStep;