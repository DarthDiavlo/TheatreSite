import React, { useEffect, useState } from 'react';
import NewsItem from '../NewsItem/NewsItem';
import { getAllNews } from '../api'; // Импортируем функцию для получения данных

function NewsList() {
  const [newsData, setNewsData] = useState([]); // Состояние для хранения данных
  const [loading, setLoading] = useState(true); // Состояние для индикации загрузки
  const [error, setError] = useState(null); // Состояние для обработки ошибок

  useEffect(() => {
    // Функция для получения данных с сервера
    const fetchNews = async () => {
      try {
        const data = await getAllNews(); // Получаем все новости
        setNewsData(data); // Сохраняем данные в состояние
      } catch (err) {
        setError(err.message); // Обрабатываем ошибку
      } finally {
        setLoading(false); // Завершаем загрузку
      }
    };

    fetchNews(); // Вызываем функцию при монтировании компонента
  }, []); // Пустой массив зависимостей означает, что эффект выполняется только при монтировании

  if (loading) {
    return <div>Загрузка новостей...</div>; // Показываем сообщение во время загрузки
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
      {newsData.map((item) => {
        const { date, time } = formatDate(item.dateTime); // Форматируем дату и время
        return (
          <NewsItem
            key={item.id}
            id={item.id}
            title={item.title}
            description={item.shortDescription}
            date={date} // Передаем отформатированную дату
            time={time} // Передаем отформатированное время
            imageUrl={`data:image/jpeg;base64,${item.image}`} // Передаем изображение в формате Base64
          />
        );
      })}
    </div>
  );
}

export default NewsList;