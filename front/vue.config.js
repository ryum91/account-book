module.exports = {
  publicPath: process.env.NODE_ENV === 'production' ? '/dist/' : '/',
  outputDir: '../server/public/dist',
  productionSourceMap: false,
  transpileDependencies: ['vuetify']
};
