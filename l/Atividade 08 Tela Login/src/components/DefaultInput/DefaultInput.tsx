import styles from './DefaultInput.module.css'

interface DefaultInputProps {
  label: string
  placeholder: string
  value: string
  onChange: (value: string) => void
}

function DefaultInput({ label, placeholder, value, onChange }: DefaultInputProps) {
  return (
    <div className={styles.inputGroup}>
      <label className={styles.label}>{label}</label>
      <input
        className={styles.input}
        type="text"
        placeholder={placeholder}
        value={value}
        onChange={(e) => onChange(e.target.value)}
      />
    </div>
  )
}

export default DefaultInput
