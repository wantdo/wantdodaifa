var durl ='http://localhost:8080/wantjs';
var s = document.createElement('script');
s.setAttribute('charset','utf-8');
s.src = 'http://localhost:8080/wantjs/js/tbdf.js';
var h = document.getElementsByTagName('head')[0];
h.insertBefore(s, h.firstChild);