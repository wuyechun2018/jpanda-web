<anychart>
  <settings>
    <animation enabled="True" />
  </settings>
  <margin left="0" top="0" right="0" bottom="0" />
  <charts>
    <chart plot_type="CategorizedVertical">
      <chart_settings>
        <legend enabled="True" position="Bottom" align="Center"
          elements_align="elements_align">
          <font size="12" />
          <title enabled="False">
            <font size="15" />
          </title>
          <columns_separator enabled="False" />
        </legend>
        <chart_background enabled="false">
          <inside_margin left="10" top="10" right="10" bottom="10" />
        </chart_background>
        
        <title enabled="true">
          <text>南方公司日售电量</text>
          <font size="15"/>
          <background enabled="false" />
        </title>
        
        <axes>
          <y_axis>
            <major_grid interlaced="true">
              <line color="#1976C3" opacity="0.5" />
            </major_grid>
            <minor_grid interlaced="true">
              <line color="#1976C3" opacity="0" />
            </minor_grid>
            <title enabled="true">
              <text></text>
            </title>
            <labels>
              <format>{%Value}{numDecimals:0}</format>            
            </labels>
          </y_axis>
          <x_axis tickmarks_placement="Center">
            <major_grid interlaced="false">
              <line color="transparent" opacity="0" />
            </major_grid>
            <minor_grid interlaced="false">
              <line color="transparent" opacity="0" />
            </minor_grid>
            <title enabled="true">
              <text></text>
            </title>
          </x_axis>
        </axes>
        <data_plot_background>
          <border enabled="false" />
          <fill opacity="0.1" color="white" />
          <effects enabled="false" />
        </data_plot_background>
      </chart_settings>
      <data_plot_settings default_series_type="Line"
        enable_3d_mode="true" z_aspect="0.5">
        <line_series>
          <tooltip_settings enabled="true" color="Blue">
            <background>
              <border type="Solid"/>
              <fill type="Solid"/>
            </background>
            <format>
            {%SeriesName} 日期: {%Name}{numDecimals:0} 值: {%YValue}
            </format>
            <font bold="true" size="12" />
          </tooltip_settings>
          <line_style>
            <line thickness="2" />
          </line_style>
          <marker_settings>
            <states>
              <normal>
                <marker type="None"/>
              </normal>
            </states>
          </marker_settings>        
        </line_series>
        <bar_series point_padding="0.2" group_padding="1" shape_type="Cylinder">
          <tooltip_settings enabled="True">
            <format>
               {%SeriesName} 日期: {%Name}{numDecimals:0} 值: {%YValue}
            </format>
            <font bold="true" size="12" />
          </tooltip_settings>
        </bar_series>      
      </data_plot_settings>
      <data>
        <series name="日售电量" type="Bar" color="#99CCFF">
          <point name="01" y="822.943 "/> 
          <point name="02" y="813.714 "/> 
          <point name="03" y="768.35 "/> 
          <point name="04" y="778.074 "/> 
          <point name="05" y="731.419 "/> 
          <point name="06" y="791.681 "/> 
          <point name="07" y="827.541 "/> 
          <point name="08" y="686.95 "/> 
          <point name="09" y="703.032 "/> 
          <point name="10" y="817.105 "/> 
          <point name="11" y="785.719 "/> 
          <point name="12" y="775.357 "/> 
          <point name="13" y="787.171 "/> 
          <point name="14" y="748.407 "/> 
          <point name="15" y="763.224 "/> 
          <point name="16" y="661.958 "/> 
          <point name="17" y="718.663 "/> 
          <point name="18" y="818.818 "/> 
          <point name="19" y="792.858 "/> 
          <point name="20" y="703.824 "/> 
          <point name="21" y="642.3779 "/> 
          <point name="22" y="0 "/> 
          <point name="23" y="0 "/> 
          <point name="24" y="0 "/> 
          <point name="25" y="0 "/> 
          <point name="26" y="0 "/> 
          <point name="27" y="0 "/> 
          <point name="28" y="0 "/> 
          <point name="29" y="0 "/> 
          <point name="30" y="0 "/> 
          <point name="31" y="0 "/> 
        </series>
        <series name="月计划日均售电量">
          <point name="01" y="578.51927 "/>
          <point name="02" y="578.51927 "/>
          <point name="03" y="578.51927 "/>
          <point name="04" y="578.51927 "/>
          <point name="05" y="578.51927 "/>
          <point name="06" y="578.51927 "/>
          <point name="07" y="578.51927 "/>
          <point name="08" y="578.51927 "/>
          <point name="09" y="578.51927 "/>
          <point name="10" y="578.51927 "/>
          <point name="11" y="578.51927 "/>
          <point name="12" y="578.51927 "/>
          <point name="13" y="578.51927 "/>
          <point name="14" y="578.51927 "/>
          <point name="15" y="578.51927 "/>
          <point name="16" y="578.51927 "/>
          <point name="17" y="578.51927 "/>
          <point name="18" y="578.51927 "/>
          <point name="19" y="578.51927 "/>
          <point name="20" y="578.51927 "/>
          <point name="21" y="578.51927 "/>
          <point name="22" y="578.51927 "/>
          <point name="23" y="578.51927 "/>
          <point name="24" y="578.51927 "/>
          <point name="25" y="578.51927 "/>
          <point name="26" y="578.51927 "/>
          <point name="27" y="578.51927 "/>
          <point name="28" y="578.51927 "/>
          <point name="29" y="578.51927 "/>
          <point name="30" y="578.51927 "/>
          <point name="31" y="578.51927 "/>
        </series>
        <series name="去年同期售电量">
          <point name="01" y="798.65 "/>
          <point name="02" y="828.608 "/>
          <point name="03" y="778.855 "/>
          <point name="04" y="863.984 "/>
          <point name="05" y="903.529 "/>
          <point name="06" y="876.81 "/>
          <point name="07" y="819.06 "/>
          <point name="08" y="784.08 "/>
          <point name="09" y="789.03 "/>
          <point name="10" y="791.67 "/>
          <point name="11" y="791.426 "/>
          <point name="12" y="809.248 "/>
          <point name="13" y="827.64 "/>
          <point name="14" y="820.292 "/>
          <point name="15" y="765.061 "/>
          <point name="16" y="790.504 "/>
          <point name="17" y="805.629 "/>
          <point name="18" y="769.263 "/>
          <point name="19" y="916.091 "/>
          <point name="20" y="856.845 "/>
          <point name="21" y="872.443 "/>
          <point name="22" y="799.931 "/>
          <point name="23" y="880.22 "/>
          <point name="24" y="881.452 "/>
          <point name="25" y="806.168 "/>
          <point name="26" y="778.36 "/>
          <point name="27" y="830.478 "/>
          <point name="28" y="837.452 "/>
          <point name="29" y="778.811 "/>
          <point name="30" y="941.38 "/>
          <point name="31" y="926.169 "/>
        </series>
      </data>
    </chart>
  </charts>
</anychart>