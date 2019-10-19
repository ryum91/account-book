module.exports = {
  lintOnSave: false,
  publicPath: '/',
  outputDir: '../dist/templates',
  assetsDir: process.env.NODE_ENV === 'production' ? '../static' : '',
  productionSourceMap: false
};
