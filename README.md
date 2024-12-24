# JCustomGUI
Manipulador das `classes` **jwa** e **Swing**.

Objetivos:
> Acelerar o processo de contrução de interfaces gráficas com o usa da classe personalizada `JCustom` e suas funcionalidades inclusas do `JCustomGUI.modules`

## Estrutura base do `JCustomGUI`

```java
import JCustomGUI.modules.*;
import javax.swing.*;
import java.awt.*;

public class test extends Frame {
  public static void main(String[] args) {
    JFrame frame = new JFrameBuilder()
    .size(400, 600)
    .location()
    .build();

    frame.setVisible(true);
  }
}
```

> Por si só esse codigo ja é capaz de instanciar uma tela `400`x`600`