export function Heading({ children }) {
  // Lógica para definir a cor dinâmica
  let dynamicStyle = { color: 'var(--texto-principal)' };

  if (typeof children === 'string') {
    if (children.includes('Lucro')) {
      dynamicStyle = { color: 'var(--lucro-azul)' };
    } else if (children.includes('Prejuízo')) {
      dynamicStyle = { color: 'var(--baixa)' };
    }
  }

  return <h1 style={dynamicStyle}>{children}</h1>;
}