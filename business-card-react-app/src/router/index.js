import React, {Component} from "react";
import {Switch, Route} from "react-router-dom";
import SignUpRoute from "./routes/signUp";
import LogInRoute from "./routes/logIn";

class Router extends Component {

    render() {

        return (
            <div className="router">

                <Switch>

                    <Route path="/sign-up" component={SignUpRoute} />

                    <Route path="/log-in" component={LogInRoute} />

                </Switch>

            </div>
        );
    }
}

export default Router;