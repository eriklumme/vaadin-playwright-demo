import { css, customElement, html, LitElement } from 'lit-element';

@customElement('login-view')
export class LoginView extends LitElement {
  static get styles() {
    return css`
      :host {
        display: block;
      }
    `;
  }

  render() {
    return html`<div>Content placeholder</div>`;
  }
}
