import React from 'react';
import { Link } from 'react-router-dom';
import styles from './Header.module.css';

function Header() {
  return (
    <header className={styles.header}>
      <div className={styles.logo}>
        <img src="/image/Teatro.png" alt="Логотип" />
      </div>
      <nav className={styles.nav}>
        <Link to="/" className={styles.navLink}>Новости</Link>
        <Link to="/poster" className={styles.navLink}>Афиша</Link>
        <Link to="/history" className={styles.navLink}>История театра</Link>
        <Link to="/contacts" className={styles.navLink}>Контактная информация</Link>
      </nav>
    </header>
  );
}

export default Header;