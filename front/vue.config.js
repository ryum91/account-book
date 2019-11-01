module.exports = {
  publicPath: process.env.NODE_ENV === 'production' ? '/public/' : '/',
  outputDir: '../server/dist/public',
  assetsDir: '',
  productionSourceMap: false,
  transpileDependencies: ['vuetify']
};
