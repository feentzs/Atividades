import React from 'react';

const DefaultButton = ({ children, type }) => {
  return (
    <button
      type={type}
      style={{
        width: '100%',
        height: '3rem',
        backgroundColor: 'var(--primary-color)',
        border: 'none',
        fontWeight: 'bold',
        borderRadius: '0.5rem',
        color: 'var(--text-main)',
        transition: 'background-color 0.3s',
        cursor: 'pointer'
      }}
      onMouseEnter={(e) => e.target.style.backgroundColor = 'var(--secondary-color)'}
      onMouseLeave={(e) => e.target.style.backgroundColor = 'var(--primary-color)'}
    >
      {children}
    </button>
  );
};

export default DefaultButton;