import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Header from './components/Header/Header';
import Footer from './components/Footer/Footer';
import NewsList from './components/NewsList/NewsList';
import NewsDetail from './components/NewsDetail/NewsDetail';
import Poster from './components/Poster/Poster';
import History from './components/History/History';
import Contacts from './components/Contacts/Contacts';
import PerformanceDetail from './components/Poster/PerformanceDetail/PerformanceDetail'; 
import NotFound from './NotFoundPage'; 
import styles from './App.module.css';

function App() {
  return (
    <div className={styles.appContainer}>
      <Router>
        <Header />
        <div className={styles.content}>
          <Routes>
            <Route path="/" element={<NewsList />} />
            <Route path="/news/:id" element={<NewsDetail />} />
            <Route path="/poster" element={<Poster />} />
            <Route path="/history" element={<History />} />
            <Route path="/contacts" element={<Contacts />} />
            <Route path="/performance/:id" element={<PerformanceDetail />} /> {/* Новый маршрут */}
            <Route path="*" element={<NotFound />} /> {/* Маршрут для 404 */}
          </Routes>
        </div>
        <Footer />
      </Router>
    </div>
  );
}

export default App;