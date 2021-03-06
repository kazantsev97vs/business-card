import React from "react";
import CustomForm from "../../../components/custom-form";
import firstNameLastNameEmail from "./firstName-lastName-Email";
import {Link} from "react-router-dom";
import {fetchCreateUserRequest, fetchCreateUserSuccess, fetchCreateUserFailure} from "../../../redux/actions/actions-on-user";
import {compose} from "redux";
import withService from "../../../additional-components/hoc/withService";
import {connect} from "react-redux";
import User from "../../../models/User";

const SignUpFirstStep = ({userController, match, fetchCreateUserRequest, fetchCreateUserSuccess, fetchCreateUserFailure}) => {

    const saveFirstNameLastNameEmail = ({firstName, lastName, email}) => {
        const user = new User(firstName, lastName, null, null, email);

        fetchCreateUserRequest();

        userController.checkEmailUniqueness(email)
            .then(res => {

                if (res) fetchCreateUserSuccess(user);

            })
            .catch(res => {

                fetchCreateUserFailure(res.error);

            });
    };

    return (
        <div>

            <CustomForm
                name="Регистрация"
                inputs={firstNameLastNameEmail}
                onClick={saveFirstNameLastNameEmail}
                href={match.path + "login&password"}
            />

            <div className="row justify-content-center">
                <Link to="log-in">или войти..?</Link>
            </div>

        </div>
    );
};

const mapStateToProps = ({user}) => ({ user });

const mapDispatchToProps = {
    fetchCreateUserRequest, fetchCreateUserSuccess, fetchCreateUserFailure
};

export default compose(
    withService(),
    connect(mapStateToProps, mapDispatchToProps)
)(SignUpFirstStep);