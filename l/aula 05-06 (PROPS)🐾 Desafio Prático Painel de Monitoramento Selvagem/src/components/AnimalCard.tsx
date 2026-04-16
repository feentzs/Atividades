import styles from './AnimalCard.module.css';

// Tipagem estrita das Props do componente
interface AnimalCardProps {
  name: string;
  species: string;
  isDangerous: boolean;
}

function AnimalCard({ name, species, isDangerous }: AnimalCardProps) {
  // Seleciona a classe do cartão com base no risco
  const cardClass = isDangerous
    ? `${styles.card} ${styles.cardDanger}`
    : `${styles.card} ${styles.cardSafe}`;

  // Seleciona a classe do badge de status com base no risco
  const statusClass = isDangerous
    ? `${styles.statusBadge} ${styles.danger}`
    : `${styles.statusBadge} ${styles.safe}`;

  // Texto condicional do status
  const statusText = isDangerous
    ? 'Status: Alerta Máximo 🐅'
    : 'Status: Tranquilo e Amigável 🦦';

  return (
    <div className={cardClass}>
      <h2 className={styles.animalName}>{name}</h2>
      <p className={styles.species}>{species}</p>
      <hr className={styles.divider} />
      <span className={statusClass}>{statusText}</span>
    </div>
  );
}

export default AnimalCard;
