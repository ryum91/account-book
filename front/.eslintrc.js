module.exports = {
  root: true,
  env: {
    node: true
  },
  extends: ['naver', 'plugin:vue/recommended', '@vue/prettier', '@vue/typescript', 'prettier'],
  plugins: ['vue'],
  parserOptions: {
    parser: '@typescript-eslint/parser'
  },
  rules: {
    'import/prefer-default-export': 'off',
    'class-methods-use-this': 'off',
    'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off'
  }
};
