import styles from './DefaultButton.module.css'

interface DefaultButtonProps {
  texto: string
  onClick: () => void
}

function DefaultButton({ texto, onClick }: DefaultButtonProps) {
  return (
    <button className={styles.button} onClick={onClick}>
      {texto}
    </button>
  )
}

export default DefaultButton
