function Modal(title = '', message='') {
  this.modalBox = document.createElement('div')
  this.modalBox.className = 'modal'
  this.modalBox.innerHTML = `
  <div class="header"><i>x</i></div>
  <div class="body"></div>
  `
}

