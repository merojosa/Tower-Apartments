package security;

public enum StateCamera 
{
	ON
	{

		@Override
		public boolean setDirection(DirectionCamera direction) 
		{
			this.direction = direction;
			System.out.println("Se cambió la dirección a " + this.direction);
			return true;
		}
		
	},
	OFF
	{

		@Override
		public boolean setDirection(DirectionCamera direction)
		{
			System.out.println("No se puede cambiar la dirección estando la cámara apagada.");
			return false;
		}
		
	};

	protected DirectionCamera direction;
	
	StateCamera()
	{
		// By default, the direction is center.
		direction = DirectionCamera.CENTER;
	}
	
	public DirectionCamera getDirection()
	{
		return direction;
	}
	
	public abstract boolean setDirection(DirectionCamera direction);
}
