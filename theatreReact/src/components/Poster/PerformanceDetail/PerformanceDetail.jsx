import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import styles from './PerformanceDetail.module.css';
import { getPerfomanceById, createTicket } from '../../api'; // Импортируем функции для получения данных и создания билета
import TicketPurchaseForm from './TicketPurchaseForm'; // Импортируем компонент формы

function PerformanceDetail() {
  const { id } = useParams(); // Получаем ID спектакля из URL
  const [performance, setPerformance] = useState(null); // Состояние для хранения данных
  const [loading, setLoading] = useState(true); // Состояние для индикации загрузки
  const [error, setError] = useState(null); // Состояние для обработки ошибок
  const [showForm, setShowForm] = useState(false); // Состояние для управления видимостью формы

  useEffect(() => {
    // Функция для получения данных с сервера
    const fetchPerformance = async () => {
      try {
        const data = await getPerfomanceById(id); // Получаем представление по ID
        setPerformance(data); // Сохраняем данные в состояние
      } catch (err) {
        setError(err.message); // Обрабатываем ошибку
      } finally {
        setLoading(false); // Завершаем загрузку
      }
    };

    fetchPerformance(); // Вызываем функцию при монтировании компонента
  }, [id]); // Зависимость от ID для перезагрузки данных при изменении ID

  if (loading) {
    return <div>Загрузка данных...</div>; // Показываем сообщение во время загрузки
  }

  if (error) {
    return <div>Ошибка: {error}</div>; // Показываем сообщение об ошибке
  }

  if (!performance) {
    return <div>Спектакль не найден</div>; // Если представление не найдено
  }

  // Функция для форматирования даты
  const formatDate = (dateTime) => {
    const date = new Date(dateTime);
    const formattedDate = date.toLocaleDateString(); // Получаем дату в формате "дд.мм.гггг"
    const formattedTime = date.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' }); // Получаем время без секунд
    return { date: formattedDate, time: formattedTime };
  };

  const { date, time } = formatDate(performance.date); // Форматируем дату и время

  // Обработчик отправки формы
  const handleFormSubmit = async (ticketData) => {
    try {
      // Отправляем данные на сервер
      console.log(ticketData)
      await createTicket(ticketData);
      alert('Билет успешно заказан!');
      setShowForm(false); // Скрываем форму после отправки
    } catch (err) {
      console.error('Ошибка при заказе билета:', err);
      alert('Ошибка при заказе билета. Попробуйте снова.');
    }
  };

  return (
    <div className={styles.performanceDetail}>
      <h1>{performance.name}</h1> {/* Используем поле name вместо title */}
      <div className={styles.info}>
        <div className={styles.scenario}>
          <h2>Краткий сценарий</h2>
          <p>{performance.decription}</p> {/* Используем поле decription */}
        </div>
        <div className={styles.director}>
          <h2>Постановщик</h2>
          <img
            src={`data:image/jpeg;base64,${performance.imageBase64}`} // Используем изображение в формате Base64
            alt={performance.name}
          />
          <p>{performance.name}</p> {/* Используем поле name */}
        </div>
        <div className={styles.actors}>
          <h2>Главные актеры</h2>
          <ul>
            {performance.workerNames.map((workerName, index) => (
              <li key={index}>{workerName}</li> // Отображаем имена работников
            ))}
          </ul>
        </div>
        <div className={styles.tickets}>
          <h2>Билеты</h2>
          <p>Осталось билетов: {performance.ticketsLeft}</p> {/* Используем поле ticketsLeft */}
          <p>Цены: от {performance.minPrice} до {performance.maxPrice} руб.</p> {/* Используем поля minPrice и maxPrice */}
        </div>
      </div>

      {/* Кнопка для открытия формы */}
      <button className={styles.buyButton} onClick={() => setShowForm(true)}>
        Приобрести билет
      </button>

      {/* Форма покупки билета */}
      {showForm && (
        <TicketPurchaseForm
          performance={{
            id: performance.id,
            date: date,
            time: time,
            minPrice: performance.minPrice,
            maxPrice: performance.maxPrice,
          }}
          onSubmit={handleFormSubmit}
          onCancel={() => setShowForm(false)}
        />
      )}
    </div>
  );
}

export default PerformanceDetail;