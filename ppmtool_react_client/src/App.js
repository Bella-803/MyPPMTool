import React from "react";
// import logo from './logo.svg';
import "./App.css";
import Dashboard from "./component/Dashboard";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./component/Layout/Header";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddProject from "./component/Project/AddProject";
import {Provider} from 'react-redux';
import store from './store'


function App() {
  return (
    <Provider store={store}>
    <Router>
      <div className="App">
        <Header />
        <Route exact path='/' component={Dashboard} />
        <Route exact path='/dashboard' component={Dashboard} />
        <Route exact path='/addProject' component={AddProject} />
      </div>
    </Router>
    </Provider>
  );
}

export default App;
