import styles from './CardAtivo.module.css';

export function CardAtivo({ titulo, children }) {
  return (
    <div className={styles.card}>
      <h3>{titulo}</h3>
      <div>{children}</div>
    </div>
  );
}