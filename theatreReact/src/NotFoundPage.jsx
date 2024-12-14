
import React from 'react';
import './NotFound.css';

function NotFound() {
    return (
        <div className="not-found-container">
          <div className="not-found">
            <h1 className="not-found-title">404</h1>
            <p className="not-found-message">Страница не найдена</p>
            <div className="not-found-animation">
              <div className="bubble bubble1"></div>
              <div className="bubble bubble2"></div>
              <div className="bubble bubble3"></div>
              <div className="bubble bubble4"></div>
            </div>
          </div>
        </div>
      );
}

export default NotFound;
