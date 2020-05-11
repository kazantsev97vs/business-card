import React from "react";
import {Switch, Route} from "react-router-dom";
import SignUpRoute from "./routes/sign-up/sign-up";
import LogInRoute from "./routes/logIn";

const Router = () => {// class Router extends Component {

    return (
        <div className="router">

            <Switch>

                <Route path="/sign-up" component={SignUpRoute} />

                <Route path="/log-in" component={LogInRoute} />

            </Switch>

        </div>
    );
};

export default Router;