import React from 'react';
import ReactDOM from 'react-dom';
import App from "./components/app";
import {Provider} from "react-redux";
import store from "./redux/store";
import ErrorBoundary from "./additional-components/error-boundary";
import {AppProvider} from "./additional-components/app-context";
import {BrowserRouter as Router} from "react-router-dom";

ReactDOM.render(
  <React.StrictMode>
      <Provider store={store}>
          <ErrorBoundary>
              <AppProvider value={null}>
                  <Router>
                      <App/>
                  </Router>
              </AppProvider>
          </ErrorBoundary>
      </Provider>
  </React.StrictMode>,
  document.getElementById('root')
);