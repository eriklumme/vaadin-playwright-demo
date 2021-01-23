import {css, customElement, html, LitElement, property} from 'lit-element';

import '@vaadin/vaadin-login';

import * as LoginEndpoint from '../../generated/LoginEndpoint';
import {Router} from "@vaadin/router";

@customElement('login-view')
export class LoginView extends LitElement {

  @property({type: Boolean})
  private error = false;

  static get styles() {
    return css`
      :host {
        display: flex;
        height: 100%;
        align-items: center;
        justify-content: center;
      }
    `;
  }

  render() {
    return html`
      <vaadin-login-form .noForgotPassword=${true} @login=${this.logIn} .error=${this.error}></vaadin-login-form>
    `;
  }

  private async logIn(event: CustomEvent) {
    const success = await LoginEndpoint.logIn(event.detail.username, event.detail.password);
    if (success) {
      Router.go('');
      return;
    }
    this.error = true;
  }
}
