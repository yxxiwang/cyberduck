﻿using Ch.Cyberduck.Ui.Winforms.Controls;

namespace Ch.Cyberduck.Ui.Winforms
{
    partial class BookmarkForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(BookmarkForm));
            this.labelNickname = new System.Windows.Forms.Label();
            this.textBoxNickname = new System.Windows.Forms.TextBox();
            this.labelURL = new System.Windows.Forms.Label();
            this.linkLabelURL = new System.Windows.Forms.LinkLabel();
            this.labelServer = new System.Windows.Forms.Label();
            this.textBoxServer = new System.Windows.Forms.TextBox();
            this.labelPort = new System.Windows.Forms.Label();
            this.textBoxPort = new System.Windows.Forms.TextBox();
            this.folderBrowserDialog = new System.Windows.Forms.FolderBrowserDialog();
            this.iconList = new System.Windows.Forms.ImageList(this.components);
            this.labelUsername = new System.Windows.Forms.Label();
            this.textBoxUsername = new System.Windows.Forms.TextBox();
            this.alertIcon = new System.Windows.Forms.PictureBox();
            this.protocol = new Ch.Cyberduck.Ui.Winforms.Controls.ImageComboBox();
            this.imageList = new System.Windows.Forms.ImageList(this.components);
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.toggleOptionsLabel = new System.Windows.Forms.Label();
            this.separatorLine = new System.Windows.Forms.Label();
            this.optionsPanel = new System.Windows.Forms.TableLayoutPanel();
            this.label1 = new System.Windows.Forms.Label();
            this.textBoxPath = new System.Windows.Forms.TextBox();
            this.comboBoxTimezone = new System.Windows.Forms.ComboBox();
            this.label8 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.richTextBoxNotes = new System.Windows.Forms.RichTextBox();
            this.labelNotes = new System.Windows.Forms.Label();
            this.comboBoxConnectMode = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.buttonWebURL = new System.Windows.Forms.Button();
            this.comboBoxEncoding = new System.Windows.Forms.ComboBox();
            this.checkBoxPKA = new System.Windows.Forms.CheckBox();
            this.labelDownloadFolder = new System.Windows.Forms.Label();
            this.textBoxWebUrl = new System.Windows.Forms.TextBox();
            this.linkLabelDownloadFolder = new System.Windows.Forms.LinkLabel();
            this.labelWebURL = new System.Windows.Forms.Label();
            this.labelTransferFiles = new System.Windows.Forms.Label();
            this.comboBoxTransferFiles = new System.Windows.Forms.ComboBox();
            this.downloadFolderButton = new System.Windows.Forms.Button();
            this.pkLabel = new System.Windows.Forms.Label();
            this.toolTip = new System.Windows.Forms.ToolTip(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.alertIcon)).BeginInit();
            this.tableLayoutPanel1.SuspendLayout();
            this.optionsPanel.SuspendLayout();
            this.SuspendLayout();
            // 
            // labelNickname
            // 
            this.labelNickname.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.labelNickname.AutoSize = true;
            this.labelNickname.Location = new System.Drawing.Point(63, 48);
            this.labelNickname.Name = "labelNickname";
            this.labelNickname.Size = new System.Drawing.Size(64, 15);
            this.labelNickname.TabIndex = 1;
            this.labelNickname.Text = "Nickname:";
            this.labelNickname.TextAlign = System.Drawing.ContentAlignment.TopRight;
            // 
            // textBoxNickname
            // 
            this.textBoxNickname.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.tableLayoutPanel1.SetColumnSpan(this.textBoxNickname, 3);
            this.textBoxNickname.Location = new System.Drawing.Point(133, 45);
            this.textBoxNickname.Name = "textBoxNickname";
            this.textBoxNickname.Size = new System.Drawing.Size(336, 23);
            this.textBoxNickname.TabIndex = 2;
            this.textBoxNickname.TextChanged += new System.EventHandler(this.textBoxNickname_TextChanged);
            // 
            // labelURL
            // 
            this.labelURL.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.labelURL.AutoSize = true;
            this.labelURL.Location = new System.Drawing.Point(96, 76);
            this.labelURL.Name = "labelURL";
            this.labelURL.Size = new System.Drawing.Size(31, 15);
            this.labelURL.TabIndex = 3;
            this.labelURL.Text = "URL:";
            this.labelURL.TextAlign = System.Drawing.ContentAlignment.TopRight;
            // 
            // linkLabelURL
            // 
            this.linkLabelURL.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Left | System.Windows.Forms.AnchorStyles.Right)));
            this.linkLabelURL.AutoEllipsis = true;
            this.tableLayoutPanel1.SetColumnSpan(this.linkLabelURL, 2);
            this.linkLabelURL.Location = new System.Drawing.Point(133, 76);
            this.linkLabelURL.Margin = new System.Windows.Forms.Padding(3);
            this.linkLabelURL.Name = "linkLabelURL";
            this.linkLabelURL.Size = new System.Drawing.Size(260, 15);
            this.linkLabelURL.TabIndex = 4;
            this.linkLabelURL.TabStop = true;
            this.linkLabelURL.Text = "default";
            this.linkLabelURL.Click += new System.EventHandler(this.linkLabelURL_Click);
            // 
            // labelServer
            // 
            this.labelServer.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.labelServer.AutoSize = true;
            this.labelServer.Location = new System.Drawing.Point(85, 104);
            this.labelServer.Name = "labelServer";
            this.labelServer.Size = new System.Drawing.Size(42, 15);
            this.labelServer.TabIndex = 5;
            this.labelServer.Text = "Server:";
            this.labelServer.TextAlign = System.Drawing.ContentAlignment.TopRight;
            // 
            // textBoxServer
            // 
            this.textBoxServer.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.textBoxServer.Location = new System.Drawing.Point(133, 101);
            this.textBoxServer.Name = "textBoxServer";
            this.textBoxServer.Size = new System.Drawing.Size(210, 23);
            this.textBoxServer.TabIndex = 6;
            this.textBoxServer.TextChanged += new System.EventHandler(this.textBoxServer_TextChanged);
            // 
            // labelPort
            // 
            this.labelPort.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.labelPort.AutoSize = true;
            this.labelPort.Location = new System.Drawing.Point(361, 104);
            this.labelPort.Name = "labelPort";
            this.labelPort.Size = new System.Drawing.Size(32, 15);
            this.labelPort.TabIndex = 7;
            this.labelPort.Text = "Port:";
            this.labelPort.TextAlign = System.Drawing.ContentAlignment.TopRight;
            // 
            // textBoxPort
            // 
            this.textBoxPort.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.textBoxPort.Location = new System.Drawing.Point(399, 101);
            this.textBoxPort.Name = "textBoxPort";
            this.textBoxPort.Size = new System.Drawing.Size(70, 23);
            this.textBoxPort.TabIndex = 8;
            this.textBoxPort.TextChanged += new System.EventHandler(this.textBoxPort_TextChanged);
            // 
            // iconList
            // 
            this.iconList.ColorDepth = System.Windows.Forms.ColorDepth.Depth8Bit;
            this.iconList.ImageSize = new System.Drawing.Size(16, 16);
            this.iconList.TransparentColor = System.Drawing.Color.Transparent;
            // 
            // labelUsername
            // 
            this.labelUsername.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.labelUsername.AutoSize = true;
            this.labelUsername.Location = new System.Drawing.Point(64, 134);
            this.labelUsername.Name = "labelUsername";
            this.labelUsername.Size = new System.Drawing.Size(63, 15);
            this.labelUsername.TabIndex = 29;
            this.labelUsername.Text = "Username:";
            this.labelUsername.TextAlign = System.Drawing.ContentAlignment.TopRight;
            // 
            // textBoxUsername
            // 
            this.textBoxUsername.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.tableLayoutPanel1.SetColumnSpan(this.textBoxUsername, 3);
            this.textBoxUsername.Location = new System.Drawing.Point(133, 129);
            this.textBoxUsername.Name = "textBoxUsername";
            this.textBoxUsername.Size = new System.Drawing.Size(336, 23);
            this.textBoxUsername.TabIndex = 30;
            this.textBoxUsername.TextChanged += new System.EventHandler(this.textBoxUsername_TextChanged);
            // 
            // alertIcon
            // 
            this.alertIcon.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.alertIcon.Image = global::Ch.Cyberduck.ResourcesBundle.alert;
            this.alertIcon.Location = new System.Drawing.Point(448, 73);
            this.alertIcon.Name = "alertIcon";
            this.alertIcon.Padding = new System.Windows.Forms.Padding(0, 2, 0, 0);
            this.alertIcon.Size = new System.Drawing.Size(21, 21);
            this.alertIcon.TabIndex = 33;
            this.alertIcon.TabStop = false;
            this.alertIcon.Visible = false;
            // 
            // protocol
            // 
            this.protocol.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.tableLayoutPanel1.SetColumnSpan(this.protocol, 4);
            this.protocol.DrawMode = System.Windows.Forms.DrawMode.OwnerDrawFixed;
            this.protocol.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.protocol.FormattingEnabled = true;
            this.protocol.ICImageList = this.iconList;
            this.protocol.IconMember = null;
            this.protocol.ItemHeight = 20;
            this.protocol.Location = new System.Drawing.Point(13, 13);
            this.protocol.MaxDropDownItems = 9;
            this.protocol.Name = "protocol";
            this.protocol.Size = new System.Drawing.Size(456, 26);
            this.protocol.TabIndex = 0;
            this.protocol.SelectionChangeCommitted += new System.EventHandler(this.protocol_SelectionChangeCommitted);
            // 
            // imageList
            // 
            this.imageList.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("imageList.ImageStream")));
            this.imageList.TransparentColor = System.Drawing.Color.Fuchsia;
            this.imageList.Images.SetKeyName(0, "arrow_up_bw.bmp");
            this.imageList.Images.SetKeyName(1, "arrow_up_color.bmp");
            this.imageList.Images.SetKeyName(2, "arrow_up_color_pressed.bmp");
            this.imageList.Images.SetKeyName(3, "arrow_down_bw.bmp");
            this.imageList.Images.SetKeyName(4, "arrow_down_color.bmp");
            this.imageList.Images.SetKeyName(5, "arrow_down_color_pressed.bmp");
            this.imageList.Images.SetKeyName(6, "green_arrow.bmp");
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.ColumnCount = 4;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 120F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 50F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle());
            this.tableLayoutPanel1.Controls.Add(this.protocol, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.labelNickname, 0, 1);
            this.tableLayoutPanel1.Controls.Add(this.alertIcon, 3, 2);
            this.tableLayoutPanel1.Controls.Add(this.textBoxUsername, 1, 4);
            this.tableLayoutPanel1.Controls.Add(this.textBoxNickname, 1, 1);
            this.tableLayoutPanel1.Controls.Add(this.labelUsername, 0, 4);
            this.tableLayoutPanel1.Controls.Add(this.labelURL, 0, 2);
            this.tableLayoutPanel1.Controls.Add(this.linkLabelURL, 1, 2);
            this.tableLayoutPanel1.Controls.Add(this.labelServer, 0, 3);
            this.tableLayoutPanel1.Controls.Add(this.textBoxServer, 1, 3);
            this.tableLayoutPanel1.Controls.Add(this.labelPort, 2, 3);
            this.tableLayoutPanel1.Controls.Add(this.textBoxPort, 3, 3);
            this.tableLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel1.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.Padding = new System.Windows.Forms.Padding(10, 10, 10, 0);
            this.tableLayoutPanel1.RowCount = 5;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 32F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(482, 157);
            this.tableLayoutPanel1.TabIndex = 36;
            // 
            // toggleOptionsLabel
            // 
            this.toggleOptionsLabel.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.toggleOptionsLabel.ImageIndex = 3;
            this.toggleOptionsLabel.ImageList = this.imageList;
            this.toggleOptionsLabel.Location = new System.Drawing.Point(13, 156);
            this.toggleOptionsLabel.Name = "toggleOptionsLabel";
            this.toggleOptionsLabel.Size = new System.Drawing.Size(168, 27);
            this.toggleOptionsLabel.TabIndex = 38;
            this.toggleOptionsLabel.Text = "        Toggle Transcript";
            this.toggleOptionsLabel.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // separatorLine
            // 
            this.separatorLine.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.separatorLine.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.separatorLine.Location = new System.Drawing.Point(17, 185);
            this.separatorLine.Name = "separatorLine";
            this.separatorLine.Size = new System.Drawing.Size(452, 2);
            this.separatorLine.TabIndex = 40;
            // 
            // optionsPanel
            // 
            this.optionsPanel.ColumnCount = 4;
            this.optionsPanel.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 120F));
            this.optionsPanel.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.optionsPanel.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 20F));
            this.optionsPanel.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 38F));
            this.optionsPanel.Controls.Add(this.label1, 0, 0);
            this.optionsPanel.Controls.Add(this.textBoxPath, 1, 0);
            this.optionsPanel.Controls.Add(this.comboBoxTimezone, 1, 10);
            this.optionsPanel.Controls.Add(this.label8, 0, 10);
            this.optionsPanel.Controls.Add(this.label2, 0, 1);
            this.optionsPanel.Controls.Add(this.richTextBoxNotes, 1, 9);
            this.optionsPanel.Controls.Add(this.labelNotes, 0, 9);
            this.optionsPanel.Controls.Add(this.comboBoxConnectMode, 1, 1);
            this.optionsPanel.Controls.Add(this.label3, 0, 2);
            this.optionsPanel.Controls.Add(this.buttonWebURL, 3, 8);
            this.optionsPanel.Controls.Add(this.comboBoxEncoding, 1, 2);
            this.optionsPanel.Controls.Add(this.checkBoxPKA, 1, 3);
            this.optionsPanel.Controls.Add(this.labelDownloadFolder, 0, 5);
            this.optionsPanel.Controls.Add(this.textBoxWebUrl, 1, 8);
            this.optionsPanel.Controls.Add(this.linkLabelDownloadFolder, 1, 5);
            this.optionsPanel.Controls.Add(this.labelWebURL, 0, 8);
            this.optionsPanel.Controls.Add(this.labelTransferFiles, 0, 6);
            this.optionsPanel.Controls.Add(this.comboBoxTransferFiles, 1, 6);
            this.optionsPanel.Controls.Add(this.downloadFolderButton, 3, 5);
            this.optionsPanel.Controls.Add(this.pkLabel, 1, 4);
            this.optionsPanel.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.optionsPanel.Location = new System.Drawing.Point(0, 194);
            this.optionsPanel.Name = "optionsPanel";
            this.optionsPanel.Padding = new System.Windows.Forms.Padding(10, 0, 10, 10);
            this.optionsPanel.RowCount = 11;
            this.optionsPanel.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
            this.optionsPanel.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
            this.optionsPanel.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
            this.optionsPanel.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
            this.optionsPanel.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
            this.optionsPanel.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
            this.optionsPanel.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
            this.optionsPanel.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
            this.optionsPanel.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
            this.optionsPanel.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.optionsPanel.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
            this.optionsPanel.Size = new System.Drawing.Size(482, 336);
            this.optionsPanel.TabIndex = 41;
            // 
            // label1
            // 
            this.label1.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(93, 6);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(34, 15);
            this.label1.TabIndex = 10;
            this.label1.Text = "Path:";
            this.label1.TextAlign = System.Drawing.ContentAlignment.TopRight;
            // 
            // textBoxPath
            // 
            this.textBoxPath.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.optionsPanel.SetColumnSpan(this.textBoxPath, 3);
            this.textBoxPath.Location = new System.Drawing.Point(133, 3);
            this.textBoxPath.Name = "textBoxPath";
            this.textBoxPath.Size = new System.Drawing.Size(336, 23);
            this.textBoxPath.TabIndex = 9;
            this.textBoxPath.TextChanged += new System.EventHandler(this.textBoxPath_TextChanged);
            // 
            // comboBoxTimezone
            // 
            this.comboBoxTimezone.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.optionsPanel.SetColumnSpan(this.comboBoxTimezone, 3);
            this.comboBoxTimezone.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboBoxTimezone.FormattingEnabled = true;
            this.comboBoxTimezone.Location = new System.Drawing.Point(133, 301);
            this.comboBoxTimezone.Name = "comboBoxTimezone";
            this.comboBoxTimezone.Size = new System.Drawing.Size(336, 23);
            this.comboBoxTimezone.TabIndex = 31;
            this.comboBoxTimezone.SelectionChangeCommitted += new System.EventHandler(this.comboBoxTimezone_SelectionChangeCommitted);
            // 
            // label8
            // 
            this.label8.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(65, 304);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(62, 15);
            this.label8.TabIndex = 27;
            this.label8.Text = "Timezone:";
            this.label8.TextAlign = System.Drawing.ContentAlignment.TopRight;
            // 
            // label2
            // 
            this.label2.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(38, 34);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(89, 15);
            this.label2.TabIndex = 11;
            this.label2.Text = "Connect Mode:";
            this.label2.TextAlign = System.Drawing.ContentAlignment.TopRight;
            // 
            // richTextBoxNotes
            // 
            this.optionsPanel.SetColumnSpan(this.richTextBoxNotes, 3);
            this.richTextBoxNotes.Dock = System.Windows.Forms.DockStyle.Fill;
            this.richTextBoxNotes.Location = new System.Drawing.Point(133, 255);
            this.richTextBoxNotes.Name = "richTextBoxNotes";
            this.richTextBoxNotes.Size = new System.Drawing.Size(336, 40);
            this.richTextBoxNotes.TabIndex = 25;
            this.richTextBoxNotes.Text = "";
            this.richTextBoxNotes.TextChanged += new System.EventHandler(this.richTextBoxNotes_TextChanged);
            // 
            // labelNotes
            // 
            this.labelNotes.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.labelNotes.AutoSize = true;
            this.labelNotes.Location = new System.Drawing.Point(86, 267);
            this.labelNotes.Name = "labelNotes";
            this.labelNotes.Size = new System.Drawing.Size(41, 15);
            this.labelNotes.TabIndex = 26;
            this.labelNotes.Text = "Notes:";
            this.labelNotes.TextAlign = System.Drawing.ContentAlignment.TopRight;
            // 
            // comboBoxConnectMode
            // 
            this.comboBoxConnectMode.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.optionsPanel.SetColumnSpan(this.comboBoxConnectMode, 3);
            this.comboBoxConnectMode.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboBoxConnectMode.FormattingEnabled = true;
            this.comboBoxConnectMode.Location = new System.Drawing.Point(133, 31);
            this.comboBoxConnectMode.Name = "comboBoxConnectMode";
            this.comboBoxConnectMode.Size = new System.Drawing.Size(336, 23);
            this.comboBoxConnectMode.TabIndex = 15;
            this.comboBoxConnectMode.SelectionChangeCommitted += new System.EventHandler(this.comboBoxConnectMode_SelectionChangeCommitted);
            // 
            // label3
            // 
            this.label3.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(67, 62);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(60, 15);
            this.label3.TabIndex = 13;
            this.label3.Text = "Encoding:";
            this.label3.TextAlign = System.Drawing.ContentAlignment.TopRight;
            // 
            // buttonWebURL
            // 
            this.buttonWebURL.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonWebURL.AutoSize = true;
            this.buttonWebURL.Image = global::Ch.Cyberduck.ResourcesBundle.site;
            this.buttonWebURL.Location = new System.Drawing.Point(438, 227);
            this.buttonWebURL.Name = "buttonWebURL";
            this.buttonWebURL.Size = new System.Drawing.Size(31, 22);
            this.buttonWebURL.TabIndex = 24;
            this.buttonWebURL.UseVisualStyleBackColor = true;
            this.buttonWebURL.Click += new System.EventHandler(this.buttonWebURL_Click);
            // 
            // comboBoxEncoding
            // 
            this.comboBoxEncoding.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.optionsPanel.SetColumnSpan(this.comboBoxEncoding, 3);
            this.comboBoxEncoding.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboBoxEncoding.FormattingEnabled = true;
            this.comboBoxEncoding.Location = new System.Drawing.Point(133, 59);
            this.comboBoxEncoding.Name = "comboBoxEncoding";
            this.comboBoxEncoding.Size = new System.Drawing.Size(336, 23);
            this.comboBoxEncoding.TabIndex = 16;
            this.comboBoxEncoding.SelectionChangeCommitted += new System.EventHandler(this.comboBoxEncoding_SelectionChangeCommitted);
            // 
            // checkBoxPKA
            // 
            this.checkBoxPKA.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.checkBoxPKA.AutoSize = true;
            this.optionsPanel.SetColumnSpan(this.checkBoxPKA, 3);
            this.checkBoxPKA.Location = new System.Drawing.Point(133, 88);
            this.checkBoxPKA.Name = "checkBoxPKA";
            this.checkBoxPKA.Size = new System.Drawing.Size(185, 19);
            this.checkBoxPKA.TabIndex = 17;
            this.checkBoxPKA.Text = "Use Public Key Authentication";
            this.checkBoxPKA.UseVisualStyleBackColor = true;
            this.checkBoxPKA.CheckedChanged += new System.EventHandler(this.checkBoxPKA_CheckedChanged);
            // 
            // labelDownloadFolder
            // 
            this.labelDownloadFolder.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.labelDownloadFolder.AutoSize = true;
            this.labelDownloadFolder.Location = new System.Drawing.Point(27, 146);
            this.labelDownloadFolder.Name = "labelDownloadFolder";
            this.labelDownloadFolder.Size = new System.Drawing.Size(100, 15);
            this.labelDownloadFolder.TabIndex = 18;
            this.labelDownloadFolder.Text = "Download Folder:";
            this.labelDownloadFolder.TextAlign = System.Drawing.ContentAlignment.TopRight;
            // 
            // textBoxWebUrl
            // 
            this.textBoxWebUrl.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.optionsPanel.SetColumnSpan(this.textBoxWebUrl, 2);
            this.textBoxWebUrl.Location = new System.Drawing.Point(133, 227);
            this.textBoxWebUrl.Name = "textBoxWebUrl";
            this.textBoxWebUrl.Size = new System.Drawing.Size(298, 23);
            this.textBoxWebUrl.TabIndex = 23;
            this.textBoxWebUrl.TextChanged += new System.EventHandler(this.textBoxWebUrl_TextChanged);
            // 
            // linkLabelDownloadFolder
            // 
            this.linkLabelDownloadFolder.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Left | System.Windows.Forms.AnchorStyles.Right)));
            this.linkLabelDownloadFolder.AutoEllipsis = true;
            this.optionsPanel.SetColumnSpan(this.linkLabelDownloadFolder, 2);
            this.linkLabelDownloadFolder.Location = new System.Drawing.Point(133, 146);
            this.linkLabelDownloadFolder.Margin = new System.Windows.Forms.Padding(3);
            this.linkLabelDownloadFolder.Name = "linkLabelDownloadFolder";
            this.linkLabelDownloadFolder.Size = new System.Drawing.Size(298, 15);
            this.linkLabelDownloadFolder.TabIndex = 19;
            this.linkLabelDownloadFolder.TabStop = true;
            this.linkLabelDownloadFolder.Text = "Desktop";
            this.linkLabelDownloadFolder.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.linkLabelDownloadFolder_LinkClicked);
            // 
            // labelWebURL
            // 
            this.labelWebURL.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.labelWebURL.AutoSize = true;
            this.labelWebURL.Location = new System.Drawing.Point(69, 230);
            this.labelWebURL.Name = "labelWebURL";
            this.labelWebURL.Size = new System.Drawing.Size(58, 15);
            this.labelWebURL.TabIndex = 22;
            this.labelWebURL.Text = "Web URL:";
            this.labelWebURL.TextAlign = System.Drawing.ContentAlignment.TopRight;
            // 
            // labelTransferFiles
            // 
            this.labelTransferFiles.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.labelTransferFiles.AutoSize = true;
            this.labelTransferFiles.Location = new System.Drawing.Point(48, 174);
            this.labelTransferFiles.Name = "labelTransferFiles";
            this.labelTransferFiles.Size = new System.Drawing.Size(79, 15);
            this.labelTransferFiles.TabIndex = 20;
            this.labelTransferFiles.Text = "Transfer Files:";
            this.labelTransferFiles.TextAlign = System.Drawing.ContentAlignment.TopRight;
            // 
            // comboBoxTransferFiles
            // 
            this.comboBoxTransferFiles.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.optionsPanel.SetColumnSpan(this.comboBoxTransferFiles, 3);
            this.comboBoxTransferFiles.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboBoxTransferFiles.FormattingEnabled = true;
            this.comboBoxTransferFiles.Location = new System.Drawing.Point(133, 171);
            this.comboBoxTransferFiles.Name = "comboBoxTransferFiles";
            this.comboBoxTransferFiles.Size = new System.Drawing.Size(336, 23);
            this.comboBoxTransferFiles.TabIndex = 21;
            this.comboBoxTransferFiles.SelectionChangeCommitted += new System.EventHandler(this.comboBoxTransferFiles_SelectionChangeCommitted);
            // 
            // downloadFolderButton
            // 
            this.downloadFolderButton.AutoSize = true;
            this.downloadFolderButton.Location = new System.Drawing.Point(437, 143);
            this.downloadFolderButton.Name = "downloadFolderButton";
            this.downloadFolderButton.Size = new System.Drawing.Size(32, 22);
            this.downloadFolderButton.TabIndex = 32;
            this.downloadFolderButton.Text = "…";
            this.downloadFolderButton.UseVisualStyleBackColor = true;
            this.downloadFolderButton.Click += new System.EventHandler(this.downloadFolderButton_Click);
            // 
            // pkLabel
            // 
            this.pkLabel.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.pkLabel.Location = new System.Drawing.Point(133, 112);
            this.pkLabel.Name = "pkLabel";
            this.pkLabel.Size = new System.Drawing.Size(278, 13);
            this.pkLabel.TabIndex = 33;
            // 
            // BookmarkForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(482, 530);
            this.Controls.Add(this.tableLayoutPanel1);
            this.Controls.Add(this.optionsPanel);
            this.Controls.Add(this.separatorLine);
            this.Controls.Add(this.toggleOptionsLabel);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.SizableToolWindow;
            this.Name = "BookmarkForm";
            this.Text = "Bookmark Editor";
            ((System.ComponentModel.ISupportInitialize)(this.alertIcon)).EndInit();
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.PerformLayout();
            this.optionsPanel.ResumeLayout(false);
            this.optionsPanel.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private ImageComboBox protocol;
        private System.Windows.Forms.Label labelNickname;
        private System.Windows.Forms.TextBox textBoxNickname;
        private System.Windows.Forms.Label labelURL;
        private System.Windows.Forms.LinkLabel linkLabelURL;
        private System.Windows.Forms.Label labelServer;
        private System.Windows.Forms.TextBox textBoxServer;
        private System.Windows.Forms.Label labelPort;
        private System.Windows.Forms.TextBox textBoxPort;
        private System.Windows.Forms.FolderBrowserDialog folderBrowserDialog;
        private System.Windows.Forms.ImageList iconList;
        private System.Windows.Forms.Label labelUsername;
        private System.Windows.Forms.TextBox textBoxUsername;
        private System.Windows.Forms.PictureBox alertIcon;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.ImageList imageList;
        private System.Windows.Forms.Label toggleOptionsLabel;
        private System.Windows.Forms.Label separatorLine;
        private System.Windows.Forms.TableLayoutPanel optionsPanel;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBoxPath;
        private System.Windows.Forms.ComboBox comboBoxTimezone;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.RichTextBox richTextBoxNotes;
        private System.Windows.Forms.Label labelNotes;
        private System.Windows.Forms.ComboBox comboBoxConnectMode;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button buttonWebURL;
        private System.Windows.Forms.ComboBox comboBoxEncoding;
        private System.Windows.Forms.CheckBox checkBoxPKA;
        private System.Windows.Forms.Label labelDownloadFolder;
        private System.Windows.Forms.TextBox textBoxWebUrl;
        private System.Windows.Forms.LinkLabel linkLabelDownloadFolder;
        private System.Windows.Forms.Label labelWebURL;
        private System.Windows.Forms.Label labelTransferFiles;
        private System.Windows.Forms.ComboBox comboBoxTransferFiles;
        private System.Windows.Forms.Button downloadFolderButton;
        private System.Windows.Forms.ToolTip toolTip;
        private System.Windows.Forms.Label pkLabel;

    }
}