import React, {Component} from "react";
import ErrorIndicator from "../error-indicator";

class ErrorBoundary extends Component {

    state = {
        hasError: false,
        error: null,
        errorInfo: null
    };

    componentDidCatch(error, errorInfo) {
        this.setState({hasError: true, error: error, errorInfo: errorInfo});
    }

    render() {
        const {hasError, error, errorInfo} = this.state;

        if (hasError) return <ErrorIndicator error={error} errorInfo={errorInfo} />;

        return this.props.children;
    }
}

export default ErrorBoundary;