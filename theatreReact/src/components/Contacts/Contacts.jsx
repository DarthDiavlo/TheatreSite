import React from 'react';
import styles from './Contacts.module.css';

function Contacts() {
  return (
    <div className={styles.contacts}>
      <h1>Контактная информация</h1>
      <div className={styles.info}>
        <p>
          <strong>Адрес:</strong> г. Москва, Красная площадь, 1
        </p>
        <p>
          <strong>Телефон:</strong> +7 (495) 123-45-67
        </p>
      </div>
      <div className={styles.map}>
        <iframe
          title="Театр на карте"
          src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2245.372974534209!2d37.61763431593096!3d55.75409479999999!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x46b54a5edc0e5a9d%3A0x5c4b8f0c0fc99a03!2z0JrRgNCw0YHQvdCw0Y8g0YPQuy4sIDEsINCc0L7RgdC60LLQsCwg0KDQvtGB0YHQuNGPLCAxMTk1MjE!5e0!3m2!1sru!2sru!4v1697274000000!5m2!1sru!2sru"
          width="100%"
          height="450"
          style={{ border: 0 }}
          allowFullScreen=""
          loading="lazy"
          referrerPolicy="no-referrer-when-downgrade"
        ></iframe>
      </div>
    </div>
  );
}

export default Contacts;