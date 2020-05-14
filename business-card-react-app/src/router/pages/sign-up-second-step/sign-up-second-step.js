import React from "react";
import CustomForm from "../../../components/custom-form";
import loginPassword from "./login-password";
import {fetchUpdateUserRequest, fetchUpdateUserSuccess, fetchUpdateUserFailure} from "../../../redux/actions/actions-on-user";
import {compose} from "redux";
import withService from "../../../additional-components/hoc/withService";
import {connect} from "react-redux";

const SignUpSecondStep = ({user, userController, fetchUpdateUserRequest, fetchUpdateUserSuccess, fetchUpdateUserFailure}) => {

    const saveLoginPassword = ({login, password}) => {
        const updatedUser = {...user.user, login, password};

        fetchUpdateUserRequest();

        userController.checkLoginUniqueness(login)
            .then(res => {

                if (res) fetchUpdateUserSuccess(updatedUser);

            })
            .catch(res => {

                fetchUpdateUserFailure(res.error);

            });
    };

    return (
        <div>

            <CustomForm
                name="Придумайте логин и пароль"
                inputs={loginPassword}
                onClick={saveLoginPassword}
                href={"additional-information"}
            />

        </div>
    );
};

const mapStateToProps = ({user}) => ({ user });

const mapDispatchToProps = {
    fetchUpdateUserRequest, fetchUpdateUserSuccess, fetchUpdateUserFailure
};

export default compose(
    withService(),
    connect(mapStateToProps, mapDispatchToProps)
)(SignUpSecondStep);