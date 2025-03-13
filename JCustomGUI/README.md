# JCustomGUI
## Estrutura base do `JCustomGUI`

> Explicações dos metodos

- [JFrameBuilder](#usando-o-jframebuilder)
- [JLabelBuilder](#usando-o-jlabelbuilder)

<details open>
  <summary style="font-size: 16px"><strong>Conteudo explicativo dos metodos anexados aos topicos acima</strong></summary>

### Usando o `JFrameBuilder`
> Tabela das propriedades e seus tipos

|Method|Type|Usage|Default|Required|
|---|:---:|---|:---:|:---:|
|__title__|`String`|"My Window title"|-|__[ x ]__|
|__icon__|`String`|"/src/img/icon.png"|-|__[ x ]__|
|__size__|int`x2`|(400, 200)|-|__[ ✓ ]__|
|__background__|`Color`|(Color.GRAY)|Color.WHITE|__[ x ]__|
|__resizable__|boolean|(`true` or `false`)|false|__[ x ]__|
|__location__|int`x2`|(50, 50)|-|__[ x ]__|
|__closeOperation__|int|(JFrame.EXIT_ON_CLOSE)|3|__[ x ]__|
|__build__|void|( )|-|__[ ✓ ]__|

```java
JFrame frame = new JFrameBuilder() // Chamando a classe personalizada
  .title("My Window") // Adicionado um nome a sua janela
  .icon("/src/icons.png") // Adicionado um icone a sua janela
  .size(400, 600) // Tamanho da janela que vai ser criada
  .background(Color.darkGray) // Alterando a cor de fundo padrão
  .resizable(true) // Tornando a janela redimencionavel
  .location() // Fazendo com que a janela inicie centralizada
  .build(); // Coleta todas as informações inseridas e aplica

frame.setVisible(true); // Exibir a janela
```

### Usando o `JLabelBuilder`
> Tabela das propriedades e seus tipos

|Method|Type|Usage|Default|Required|
|---|:---:|:---|:---:|:---:|
|__content__|`String`|"Some text"|-|__[ x ]__|
|__background__|`Color`|(Color.GRAY)|-|__[ x ]__|
|__foreground__|`Color`|(Color.WHITE)|-|__[ x ]__|
|__borderRadius__|`Integer`|(10) or (null)|10|__[ x ]__|
|__padding__|int`x1 or 2`|(10, 10) or (10)|-|__[ x ]__|
|__font__|`Font`|new Font(Font.SERIF, Font.BOLD, 30)|SANS_SERIF, Font.BOLD, 20|__[ x ]__|
|__image__|`String`||-|__[ x ]__|
|__location__|int`x2`|(50, 50)|-|__[ ✓ ]__|
|__build__|void|( )|-|__[ ✓ ]__|

```java
JLabel text = new JLabelBuilder()
  .content("Login") // Texto a ser exibido
  .background(Color.GRAY) // Adiciona uma cor de fundo e o arredondamento da borda
  .foreground(Color.GRAY) // Alterando a cor do texto
  .location(150, 5) // O elemento inicia a 140px de largura e 20px de altura de acordo com o janela
  .font(new Font(Font.MONOSPACED, Font.BOLD, 30)) // Fonte monospace, estilo bold, tamanho 30
  .build(); // Coleta todas as informações inseridas e aplica

frame.add(text); // Exibir na sua janela anteriormente criada
```

### Usando o `JInputBuilder`
> Metodos/SubClasses e suas propriedades
<details>
<summary><span style="font-size: 17px">Text</span></summary>

> JTextField inputName = new JInputBuilder.Text()

|Method|Type|Usage|Default|Required|
|---|:---:|---|:---:|:---:|
|__background__|`Color`|(Color.WHITE)|Color.WHITE|__[ x ]__|
|__foreground__|`Color`|(Color.GRAY)|Color.GRAY|__[ x ]__|
|__font__|`Font`|new Font(Font.SERIF, Font.BOLD, 30)|new Font(Font.SANS_SERIF, Font.BOLD, 30)|__[ x ]__|
|__size__|int`x2`|(400, 200)|-|__[ x ]__|
|__location__|int`x2`|(50, 50)|-|__[ x ]__|
|__build__|void|( )|-|__[ ✓ ]__|

```java
JTextField inputName = new JInputBuilder.Text()
  .size(200, 30)
  .font(new Font(Font.SANS_SERIF, Font.BOLD, 18))
  .location(100, 60)
  .font(new Font(Font.SANS_SERIF, Font.BOLD, 15))
  .build();
```
</details>
<details>
<summary><span style="font-size: 17px">Password</span></summary>

> JTextField inputPass = new JInputBuilder.Password()

|Method|Type|Usage|Default|Required|
|---|:---:|---|:---:|:---:|
|__background__|`Color`|(Color.WHITE)|Color.WHITE|__[ x ]__|
|__foreground__|`Color`|(Color.GRAY)|Color.BLACK|__[ x ]__|
|__font__|`Font`|new Font(Font.SERIF, Font.BOLD, 30)|new Font(Font.SANS_SERIF, Font.BOLD, 30)|__[ x ]__|
|__size__|int`x2`|(400, 200)|-|__[ x ]__|
|__location__|int`x2`|(50, 50)|-|__[ x ]__|
|__build__|void|( )|-|__[ ✓ ]__|

```java
JPasswordField inputPassword = new JInputBuilder.Password()
  .size(200, 30) // Tamanho do component
  .font(new Font(Font.SANS_SERIF, Font.BOLD, 18)) // Gerenciamento de font
  .location(100, 60) // Localização do component X e Y
  .build();
```
</details>
<details>
<summary><span style="font-size: 17px">TextArea</span></summary>

> JComponent textArea = new JInputBuilder.TextArea()

|Method|Type|Usage|Default|Required|
|---|:---:|---|:---:|:---:|
|__background__|`Color`|(Color.WHITE)|WHITE|__[ x ]__|
|__foreground__|`Color`|(Color.GRAY)|GRAY|__[ x ]__|
|__font__|`Font`|new Font(Font.SERIF, Font.BOLD, 30)|new Font(Font.SANS_SERIF, Font.BOLD, 30)|__[ x ]__|
|__borderRadius__|`Integer`|(10) or (null)|-|__[ x ]__|
|__size__|int`x2`|(400, 200)|-|__[ x ]__|
|__scroll__|boolean`x3`|(true, false, true)|(false, false, false)|__[ x ]__|
|__location__|int`x2`|(50, 50)|-|__[ x ]__|
|__build__|void|( )|-|__[ ✓ ]__|

```java
JComponent area = new JInputBuilder.TextArea()
  .size(200, 120) // Tamanho do component
  .location(100, 200) // Localização X e Y
  .borderRadius(20) // Arredondamento das bordas, por padrão para "null" é  10
  .background(Color.decode("#D0F0F0")) // Cor de fundo
  .scroll(true, true, true) // Permite edição, impede quebra de linha, impede quebra de palavras
  .build();
```
</details>
</details>

### Usando o `JButtonBuilder`
> Tabela das propriedades e seus tipos

|Method|Type|Usage|Default|Required|
|---|:---:|:---|:---:|:---:|
|__text__|`String`|"Some text"|-|__[ x ]__|
|__background__|`Color`|(Color.GRAY)|Color.GRAY|__[ x ]__|
|__foreground__|`Color`|(Color.WHITE)|Color.WHITE|__[ x ]__|
|__borderRadius__|`Integer`|(10) or (null)|-|__[ x ]__|
|__font__|`Font`|new Font(Font.SERIF, Font.BOLD, 30)|SANS_SERIF, Font.BOLD, 20|__[ x ]__|
|__cursor__|`int`|Cursor.HAND_CURSOR|Cursor.HAND_CURSOR|__[ x ]__|
|__icon__|`ImageIcon`||-|__[ x ]__|
|__location__|int`x2`|(50, 50)|-|__[ ✓ ]__|
|__build__|void|( )|-|__[ ✓ ]__|

```java
JButton button = new JButtonBuilder()
  .text("Send") // Mensagem a ser exibida
  .location(160, 450) // Localização X e Y do botão
  .size(80, 50) // Dimenções X e Y do tamanho do botão
  .borderRadius(null) // Arredondamento das bordas, por padrão para "null" é  10
  .build(); // Coleta todas as informações inseridas e aplica

frame.add(text); // Exibir na sua janela anteriormente criada
```