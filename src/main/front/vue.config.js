module.exports = {
  lintOnSave: false,
  publicPath: '/',
  outputDir: '../resources/templates',
  assetsDir: process.env.NODE_ENV === 'production' ? '../static' : '',
  productionSourceMap: false
};
