import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import PerformanceCard from './PerformanceCard/PerformanceCard';
import { getAllPerfomances } from '../api'; // Импортируем функцию для получения данных

function Poster() {
  const [performances, setPerformances] = useState([]); // Состояние для хранения данных
  const [loading, setLoading] = useState(true); // Состояние для индикации загрузки
  const [error, setError] = useState(null); // Состояние для обработки ошибок

  useEffect(() => {
    // Функция для получения данных с сервера
    const fetchPerformances = async () => {
      try {
        const data = await getAllPerfomances(); // Получаем все представления
        setPerformances(data); // Сохраняем данные в состояние
      } catch (err) {
        setError(err.message); // Обрабатываем ошибку
      } finally {
        setLoading(false); // Завершаем загрузку
      }
    };

    fetchPerformances(); // Вызываем функцию при монтировании компонента
  }, []); // Пустой массив зависимостей означает, что эффект выполняется только при монтировании

  if (loading) {
    return <div>Загрузка афиши...</div>; // Показываем сообщение во время загрузки
  }

  if (error) {
    return <div>Ошибка: {error}</div>; // Показываем сообщение об ошибке
  }

  // Функция для форматирования даты
  const formatDate = (dateTime) => {
    const date = new Date(dateTime);
    const formattedDate = date.toLocaleDateString(); // Получаем дату в формате "дд.мм.гггг"
    const formattedTime = date.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' }); // Получаем время без секунд
    return { date: formattedDate, time: formattedTime };
  };

  return (
    <div>
      <h1>Афиша</h1>
      {performances.map((performance) => {
        const { date, time } = formatDate(performance.date); // Форматируем дату и время
        return (
          <Link to={`/performance/${performance.id}`} key={performance.id}>
            <PerformanceCard
              title={performance.name} // Используем поле name вместо title
              description={performance.style} // Используем поле style вместо description
              date={date} // Передаем отформатированную дату
              time={time} // Передаем отформатированное время
              imageUrl={`data:image/jpeg;base64,${performance.imageBase64}`} // Передаем изображение в формате Base64
            />
          </Link>
        );
      })}
    </div>
  );
}

export default Poster;