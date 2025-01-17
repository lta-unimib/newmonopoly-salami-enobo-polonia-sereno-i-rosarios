import React from 'react';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import './App.css';
import Home from "./pages/home/Home.tsx";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
          <Routes>
              <Route path="/" element={<Home/>}/>
          </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
