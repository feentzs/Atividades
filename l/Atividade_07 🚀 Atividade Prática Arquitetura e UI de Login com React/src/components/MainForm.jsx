import React from 'react';

const MainForm = ({ children }) => {
  return (
    <div style={{
      maxWidth: '25rem',
      padding: '2.5rem',
      borderRadius: '0.75rem',
      backgroundColor: 'var(--bg-card)'
    }}>
      {children}
    </div>
  );
};

export default MainForm;